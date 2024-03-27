import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x27;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Iso14229Serv0x27Test {

    private Iso14229Serv0x27 iso14229Serv0x27;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;
    private byte[] mockRxFrame;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        mockRxFrame = new byte[8];
        iso14229Serv0x27 = new Iso14229Serv0x27(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        mockRxFrame[1] = (byte) 0x67; // Positive Response
        int resultCode = iso14229Serv0x27.processResponse(mockRxFrame);
        assertEquals(Iso14229Serv0x27.buildResultCode((byte) 0x27, Iso14229Serv0x27.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        mockRxFrame[1] = (byte) 0x7F; // Negative Response
        mockRxFrame[2] = (byte) 0x12; // NRC: Service Not Supported
        int resultCode = iso14229Serv0x27.processResponse(mockRxFrame);
        assertEquals(Iso14229Serv0x27.buildResultCode((byte) 0x27, Iso14229Serv0x27.NEGATIVE_RESPONSE, (byte) 0x12), resultCode);
    }

    @Test
    public void testExecuteDiagnosticService_Success() {
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x01);
        byte[] mockRequestFrame = new byte[]{(byte) 0x27, (byte) 0x01};
        byte[] mockSeedResponseFrame = new byte[]{(byte) 0x67, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44}; // Positive Response with seed
        byte[] mockSendKeyRequestFrame = new byte[]{(byte) 0x27, (byte) 0x02, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44};
        byte[] mockSuccessResponseFrame = new byte[]{(byte) 0x67}; // Positive Response

        when(mockUdsInterface.sendRequest(mockRequestFrame, mockRequestFrame.length)).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(mockSeedResponseFrame, mockSuccessResponseFrame);

        int resultCode = iso14229Serv0x27.executeDiagnosticService();

        assertEquals(Iso14229Serv0x27.buildResultCode((byte) 0x27, Iso14229Serv0x27.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testExecuteDiagnosticService_Failure() {
        when(mockServiceInfo.getSubfunctionID()).thenReturn((byte) 0x01);
        byte[] mockRequestFrame = new byte[]{(byte) 0x27, (byte) 0x01};
        byte[] mockSeedResponseFrame = new byte[]{(byte) 0x67, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44}; // Positive Response with seed
        byte[] mockSendKeyRequestFrame = new byte[]{(byte) 0x27, (byte) 0x02, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44};
        byte[] mockFailureResponseFrame = new byte[]{(byte) 0x7F, (byte) 0x12}; // Negative Response: Service Not Supported

        when(mockUdsInterface.sendRequest(mockRequestFrame, mockRequestFrame.length)).thenReturn(true);
        when(mockUdsInterface.readResponse(any(), any())).thenReturn(true);
        when(mockUdsInterface.getResponse()).thenReturn(mockSeedResponseFrame, mockFailureResponseFrame);

        int resultCode = iso14229Serv0x27.executeDiagnosticService();

        assertEquals(Iso14229Serv0x27.buildResultCode((byte) 0x27, Iso14229Serv0x27.FAILED, (byte) 0xFF), resultCode);
    }
}
