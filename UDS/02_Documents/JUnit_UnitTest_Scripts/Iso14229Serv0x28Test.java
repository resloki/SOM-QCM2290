import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x28;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Iso14229Serv0x28Test {

    private Iso14229Serv0x28 iso14229Serv0x28;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x28 = new Iso14229Serv0x28(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame_NoOptionalBytes() {
        byte[] expectedRequestFrame = {(byte) 0x28, 0x02, 0x05};
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x02);
        when(mockServiceInfo.getCommunicationType()).thenReturn((byte) 0x05);
        byte[] requestFrame = iso14229Serv0x28.buildRequestFrame();
        assertEquals(expectedRequestFrame.length, requestFrame.length);
        for (int i = 0; i < expectedRequestFrame.length; i++) {
            assertEquals(expectedRequestFrame[i], requestFrame[i]);
        }
    }

    @Test
    public void testBuildRequestFrame_WithOptionalBytes() {
        byte[] expectedRequestFrame = {(byte) 0x28, 0x02, 0x05, 0x00, 0x01};
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x02);
        when(mockServiceInfo.getCommunicationType()).thenReturn((byte) 0x05);
        Map<Integer, Byte> optionalBytes = new HashMap<>();
        optionalBytes.put(3, (byte) 0x00);
        optionalBytes.put(4, (byte) 0x01);
        iso14229Serv0x28.setOptionalBytesUsed(true);
        iso14229Serv0x28.setOptionalBytes(optionalBytes);
        byte[] requestFrame = iso14229Serv0x28.buildRequestFrame();
        assertEquals(expectedRequestFrame.length, requestFrame.length);
        for (int i = 0; i < expectedRequestFrame.length; i++) {
            assertEquals(expectedRequestFrame[i], requestFrame[i]);
        }
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        byte[] rxFrame = {(byte) 0x84}; // Positive Response
        int resultCode = iso14229Serv0x28.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x28.buildResultCode((byte) 0x28, Iso14229Serv0x28.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x31}; // Negative Response: RequestOutOfRange
        int resultCode = iso14229Serv0x28.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x28.buildResultCode((byte) 0x28, Iso14229Serv0x28.NEGATIVE_RESPONSE, (byte) 0x31), resultCode);
    }

    @Test
    public void testExecuteDiagnosticService_Success() {
        byte[] requestFrame = {(byte) 0x28, 0x02, 0x05};
        byte[] rxFrame = {(byte) 0x84}; // Positive Response
        when(mockUdsInterface.sendRequest(requestFrame, requestFrame.length)).thenReturn(true);
        when(mockUdsInterface.readResponse(null, 0)).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(rxFrame);
        int resultCode = iso14229Serv0x28.executeDiagnosticService();
        assertEquals(Iso14229Serv0x28.buildResultCode((byte) 0x28, Iso14229Serv0x28.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testExecuteDiagnosticService_Timeout() {
        byte[] requestFrame = {(byte) 0x28, 0x02, 0x05};
        when(mockUdsInterface.sendRequest(requestFrame, requestFrame.length)).thenReturn(true);
        when(mockUdsInterface.readResponse(null, 0)).thenReturn(false);
        int resultCode = iso14229Serv0x28.executeDiagnosticService();
        assertEquals(Iso14229Serv0x28.buildResultCode((byte) 0x28, Iso14229Serv0x28.FAILED, (byte) 0xFF), resultCode);
    }
}
