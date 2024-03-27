import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x35;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Iso14229Serv0x35Test {

    private Iso14229Serv0x35 iso14229Serv0x35;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x35 = new Iso14229Serv0x35(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame() {
        when(mockServiceInfo.getUdsRequest().getStartAddressMemoryUpload()).thenReturn((byte) 0x12);
        when(mockServiceInfo.getUdsRequest().getLengthMemoryUpload()).thenReturn(0x5678);

        byte[] requestFrame = iso14229Serv0x35.buildRequestFrame();

        assertEquals(8, requestFrame.length);
        assertEquals(0x05, requestFrame[0]); // Length of the request frame
        assertEquals(0x35, requestFrame[1]); // Service ID
        assertEquals(0x12, requestFrame[2]); // Start address of memory
        assertEquals(0x56, requestFrame[3]); // High byte of memory length
        assertEquals(0x78, requestFrame[4]); // Low byte of memory length
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        byte[] rxFrame = {(byte) 0x75}; // Positive Response
        int resultCode = iso14229Serv0x35.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x35.buildResultCode((byte) 0x35, Iso14229Serv0x35.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x35, (byte) 0x78}; // Negative Response: RequestOutOfRange
        int resultCode = iso14229Serv0x35.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x35.buildResultCode((byte) 0x35, Iso14229Serv0x35.NEGATIVE_RESPONSE, (byte) 0x78), resultCode);
    }

    // Similar test cases can be added for executeDiagnosticService() method
}
