import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x37;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Iso14229Serv0x37Test {

    private Iso14229Serv0x37 iso14229Serv0x37;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x37 = new Iso14229Serv0x37(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame_NoOptionalBytes() {
        byte[] requestFrame = iso14229Serv0x37.buildRequestFrame();
        assertEquals(1, requestFrame.length);
        assertEquals(0x37, requestFrame[0]);
    }

    @Test
    public void testBuildRequestFrame_WithOptionalBytes() {
        // Configure mock ServiceInfo to include optional bytes
        when(mockServiceInfo.isOptionalBytesUsed()).thenReturn(true);
        when(mockServiceInfo.getOptionalBytes()).thenReturn(TestUtils.createOptionalBytesMap());

        byte[] requestFrame = iso14229Serv0x37.buildRequestFrame();
        assertEquals(4, requestFrame.length);
        assertEquals(0x37, requestFrame[0]);
        assertEquals(TestUtils.OPTIONAL_BYTE_VALUE_1, requestFrame[1]);
        assertEquals(TestUtils.OPTIONAL_BYTE_VALUE_2, requestFrame[2]);
        assertEquals(TestUtils.OPTIONAL_BYTE_VALUE_3, requestFrame[3]);
    }

    @Test
    public void testProcessResponse_SuccessfulResponse() {
        byte[] rxFrame = {(byte) 0x77}; // Positive Response
        when(mockServiceInfo.getResponseFrame()).thenReturn(rxFrame);
        when(mockServiceInfo.getServiceResponse()).thenReturn(ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS);

        int resultCode = iso14229Serv0x37.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x37.SUCCESS, resultCode);
    }

    @Test
    public void testProcessResponse_UnsuccessfulResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x37, (byte) 0x22}; // Negative Response: RequestOutOfRange
        when(mockServiceInfo.getResponseFrame()).thenReturn(rxFrame);
        when(mockServiceInfo.getServiceResponse()).thenReturn(ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS);

        int resultCode = iso14229Serv0x37.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x37.buildResultCode((byte) 0x37, Iso14229Serv0x37.NEGATIVE_RESPONSE, (byte) 0x22), resultCode);
    }
 
}
