import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Iso14229Serv0x22Test {

    private Iso14229Serv0x22 iso14229Serv0x22;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;
    private byte[] mockRxFrame;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        mockRxFrame = new byte[8];
        iso14229Serv0x22 = new Iso14229Serv0x22(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame() {
        UdsRequest udsRequest = new UdsRequest();
        udsRequest.optionalBytesUsed = true;
        udsRequest.optionalBytesBufferLength = 2;
        udsRequest.dataIdentifierInfo = new UdsRequest.DataIdentifierInfo();
        udsRequest.dataIdentifierInfo.number = 0x1234;
        udsRequest.subfunctionID = 0x22;
        udsRequest.optionalBytes = new HashMap<>();
        udsRequest.optionalBytes.put(4, (byte) 0xAB);
        udsRequest.optionalBytes.put(5, (byte) 0xCD);
        when(mockServiceInfo.getDTCInfo()).thenReturn(null);
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x22);
        iso14229Serv0x22.setRequest(udsRequest);
        byte[] requestFrame = iso14229Serv0x22.buildRequestFrame();
        assertEquals(8, requestFrame.length);
        assertEquals(8, requestFrame[0]); // Request frame total length
        assertEquals((byte) 0x22, requestFrame[1]); // Service ID
        assertEquals((byte) 0x12, requestFrame[2]); // MSB of data identifier
        assertEquals((byte) 0x34, requestFrame[3]); // LSB of data identifier
        assertEquals((byte) 0xAB, requestFrame[4]); // Optional byte 1
        assertEquals((byte) 0xCD, requestFrame[5]); // Optional byte 2
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        mockRxFrame[1] = (byte) 0x62; // Positive Response
        int resultCode = iso14229Serv0x22.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x22, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        mockRxFrame[1] = (byte) 0x7F; // Negative Response
        mockRxFrame[2] = (byte) 0x12; // NRC: Service Not Supported
        int resultCode = iso14229Serv0x22.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x22, UdsDiagnosticService.NEGATIVE_RESPONSE, (byte) 0x12), resultCode);
    }

    @Test
    public void testExecuteDiagnosticService_Success() {
        UdsRequest udsRequest = new UdsRequest();
        udsRequest.optionalBytesUsed = false;
        udsRequest.dataIdentifierInfo = new UdsRequest.DataIdentifierInfo();
        udsRequest.dataIdentifierInfo.number = 0x1234;
        udsRequest.subfunctionID = 0x22;
        when(mockServiceInfo.getDTCInfo()).thenReturn(null);
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x22);
        iso14229Serv0x22.setRequest(udsRequest);
        byte[] mockRequestFrame = new byte[]{(byte) 0x06, (byte) 0x22, (byte) 0x12, (byte) 0x34};
        byte[] mockResponseFrame = new byte[]{(byte) 0x62}; // Positive Response
        when(mockUdsInterface.sendRequest(any(), any())).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(mockResponseFrame);

        int resultCode = iso14229Serv0x22.executeDiagnosticService();

        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x22, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
        verify(mockUdsInterface).sendRequest(mockRequestFrame, mockRequestFrame.length);
        verify(mockUdsInterface).readResponse(any(ResponseFrameContainer.class), any(long.class));
    }

    @Test
    public void testExecuteDiagnosticService_Timeout() {
        UdsRequest udsRequest = new UdsRequest();
        udsRequest.optionalBytesUsed = false;
        udsRequest.dataIdentifierInfo = new UdsRequest.DataIdentifierInfo();
        udsRequest.dataIdentifierInfo.number = 0x1234;
        udsRequest.subfunctionID = 0x22;
        when(mockServiceInfo.getDTCInfo()).thenReturn(null);
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x22);
        iso14229Serv0x22.setRequest(udsRequest);
        byte[] mockRequestFrame = new byte[]{(byte) 0x06, (byte) 0x22, (byte) 0x12, (byte) 0x34
