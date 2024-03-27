import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

public class Iso14229Serv0x19Test {

    private Iso14229Serv0x19 iso14229Serv0x19;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;
    private byte[] mockRxFrame;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        mockRxFrame = new byte[8];
        iso14229Serv0x19 = new Iso14229Serv0x19(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        mockRxFrame[1] = (byte) 0x51; // Positive Response
        int resultCode = iso14229Serv0x19.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x19, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        mockRxFrame[1] = (byte) 0x7F; // Negative Response
        mockRxFrame[2] = (byte) 0x12; // NRC: Service Not Supported
        int resultCode = iso14229Serv0x19.processResponse(mockRxFrame);
        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x19, UdsDiagnosticService.NEGATIVE_RESPONSE, (byte) 0x12), resultCode);
    }

    @Test
    public void testBuildRequestFrame() {
        byte[] expectedRequestFrame = {(byte) 0x19, (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x02};
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x00);
        when(mockServiceInfo.getDTCInfo()).thenReturn(new DTCInfo((byte) 0x01, (byte) 0x02, (byte) 0x02));
        byte[] actualRequestFrame = iso14229Serv0x19.buildRequestFrame();
        assertEquals(expectedRequestFrame.length, actualRequestFrame.length);
        for (int i = 0; i < expectedRequestFrame.length; i++) {
            assertEquals(expectedRequestFrame[i], actualRequestFrame[i]);
        }
    }

    @Test
    public void testExecuteDiagnosticService_Success() {
        byte[] mockRequestFrame = new byte[]{(byte) 0x19, (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x02};
        byte[] mockResponseFrame = new byte[]{(byte) 0x51}; // Positive Response
        when(mockUdsInterface.sendRequest(any(), any())).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(mockResponseFrame);

        int resultCode = iso14229Serv0x19.executeDiagnosticService();

        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x19, UdsDiagnosticService.SUCCESS, (byte) 0), resultCode);
        verify(mockUdsInterface).sendRequest(mockRequestFrame, mockRequestFrame.length);
        verify(mockUdsInterface).readResponse(any(ResponseFrameContainer.class), any(long.class));
    }

    @Test
    public void testExecuteDiagnosticService_Timeout() {
        when(mockUdsInterface.sendRequest(any(), any())).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(false);

        int resultCode = iso14229Serv0x19.executeDiagnosticService();

        assertEquals(UdsDiagnosticService.buildResultCode((byte) 0x19, UdsDiagnosticService.FAILED, (byte) 0), resultCode);
    }
}
