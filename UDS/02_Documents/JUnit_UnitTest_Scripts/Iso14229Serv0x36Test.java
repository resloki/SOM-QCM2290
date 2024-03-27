import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x36;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Iso14229Serv0x36Test {

    private Iso14229Serv0x36 iso14229Serv0x36;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x36 = new Iso14229Serv0x36(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame() {
        byte[] requestFrame = iso14229Serv0x36.buildRequestFrame();
        assertEquals(1, requestFrame.length);
        assertEquals(0x36, requestFrame[0]);
    }

    @Test
    public void testProcessResponse_SuccessfulResponse() {
        byte[] rxFrame = {(byte) 0x76}; // Positive Response
        when(mockServiceInfo.getResponseFrame()).thenReturn(rxFrame);
        when(mockServiceInfo.getServiceResponse()).thenReturn(ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS);

        int resultCode = iso14229Serv0x36.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x36.SUCCESS, resultCode);
    }

    @Test
    public void testProcessResponse_UnsuccessfulResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x36, (byte) 0x22}; // Negative Response: RequestOutOfRange
        when(mockServiceInfo.getResponseFrame()).thenReturn(rxFrame);
        when(mockServiceInfo.getServiceResponse()).thenReturn(ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS);

        int resultCode = iso14229Serv0x36.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x36.buildResultCode((byte) 0x36, Iso14229Serv0x36.NEGATIVE_RESPONSE, (byte) 0x22), resultCode);
    }

    // Additional test cases for executeDiagnosticService() can be added to handle different scenarios.
}
