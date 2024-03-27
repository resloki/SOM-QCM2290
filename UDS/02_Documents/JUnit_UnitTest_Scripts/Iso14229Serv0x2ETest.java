import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class Iso14229Serv0x2ETest {

    private Iso14229Serv0x2E iso14229Serv0x2E;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;
    private byte[] mockRxFrame;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        mockRxFrame = new byte[8];
        iso14229Serv0x2E = new Iso14229Serv0x2E(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        mockRxFrame[1] = (byte) 0x6E; // Positive Response
        int resultCode = iso14229Serv0x2E.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x2E, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        mockRxFrame[1] = (byte) 0x6F; // Negative Response
        mockRxFrame[2] = (byte) 0x12; // NRC: Service Not Supported
        int resultCode = iso14229Serv0x2E.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x2E, UdsDiagnosticService.NEGATIVE_RESPONSE, (byte) 0x12), resultCode);
    }

    @Test
    public void testBuildRequestFrame() {
        byte[] mockDataIdentifier = new byte[]{0x12, 0x34}; // Data Identifier: 0x1234
        Map<Integer, Byte> mockByteValues = new HashMap<>();
        mockByteValues.put(0, (byte) 0xAA);
        mockByteValues.put(1, (byte) 0xBB);
        when(mockServiceInfo.getDataIdentifier()).thenReturn(mockDataIdentifier);
        when(mockServiceInfo.getDataIdentifierBufferLength()).thenReturn((byte) 2);
        when(mockServiceInfo.getByteValues()).thenReturn(mockByteValues);
        byte[] expectedRequestFrame = {(byte) 0x06, (byte) 0x2E, (byte) 0x1F, (byte) 0x34, (byte) 0x12, (byte) 0xAA, (byte) 0xBB}; // Total Length: 0x06, Service ID: 0x2E, Data Identifier: 0x1234, Byte Values: 0xAA, 0xBB
        byte[] actualRequestFrame = iso14229Serv0x2E.buildRequestFrame();
        assertEquals(expectedRequestFrame.length, actualRequestFrame.length);
        for (int i = 0; i < expectedRequestFrame.length; i++) {
            assertEquals(expectedRequestFrame[i], actualRequestFrame[i]);
        }
    }

    @Test
    public void testExecuteDiagnosticService_Success() {
        byte[] mockRequestFrame = new byte[]{(byte) 0x06, (byte) 0x2E, (byte) 0x1F, (byte) 0x34, (byte) 0x12, (byte) 0xAA, (byte) 0xBB}; // Total Length: 0x06, Service ID: 0x2E, Data Identifier: 0x1234, Byte Values: 0xAA, 0xBB
        byte[] mockResponseFrame = new byte[]{(byte) 0x6E}; // Positive Response
        when(mockUdsInterface.sendRequest(any(), any())).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(mockResponseFrame);

        int resultCode = iso14229Serv0x2E.executeDiagnosticService();

        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x2E, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
        verify(mockUdsInterface).sendRequest(mockRequestFrame, mockRequestFrame.length);
        verify(mockUdsInterface).readResponse(any(ResponseFrameContainer.class), any(long.class));
    }

    @Test
    public void testExecuteDiagnosticService_Timeout() {
        when(mockUdsInterface.sendRequest(any(), any())).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(false);

        int resultCode = iso14229Serv0x2E.executeDiagnosticService();

        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x2E, UdsDiagnosticService.FAILED, (byte) 0), resultCode);
    }
}
