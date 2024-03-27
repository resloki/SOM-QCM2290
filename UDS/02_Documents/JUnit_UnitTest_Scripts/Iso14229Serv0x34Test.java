import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x34;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Iso14229Serv0x34Test {

    private Iso14229Serv0x34 iso14229Serv0x34;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x34 = new Iso14229Serv0x34(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame() {
        when(mockServiceInfo.getFirmwareProgramFile()).thenReturn(mock(FirmwareProgramFile.class));
        FirmwareProgramFile mockFirmwareProgramFile = mock(FirmwareProgramFile.class);
        when(mockFirmwareProgramFile.getStartAddress()).thenReturn(0x11223344);
        when(mockFirmwareProgramFile.getTotalLength()).thenReturn(0x55667788);

        when(mockServiceInfo.getFirmwareProgramFile()).thenReturn(mockFirmwareProgramFile);

        byte[] requestFrame = iso14229Serv0x34.buildRequestFrame();

        assertEquals(11, requestFrame.length);
        assertEquals(0x34, requestFrame[0]); // Service ID
        assertEquals(0x00, requestFrame[1]); // Subfunction ID
        assertEquals(0x44, requestFrame[2]); // Block Sequence Counter
        assertEquals(0x11, requestFrame[3]); // Start address byte 1
        assertEquals(0x22, requestFrame[4]); // Start address byte 2
        assertEquals(0x33, requestFrame[5]); // Start address byte 3
        assertEquals(0x44, requestFrame[6]); // Start address byte 4
        assertEquals(0x55, requestFrame[7]); // Total length byte 1
        assertEquals(0x66, requestFrame[8]); // Total length byte 2
        assertEquals(0x77, requestFrame[9]); // Total length byte 3
        assertEquals(0x88, requestFrame[10]); // Total length byte 4
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        byte[] rxFrame = {(byte) 0x74, 0x00, 0x11, 0x22}; // Positive Response with maximum block length
        int resultCode = iso14229Serv0x34.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x34.buildResultCode((byte) 0x34, Iso14229Serv0x34.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x34, (byte) 0x78}; // Negative Response: RequestOutOfRange
        int resultCode = iso14229Serv0x34.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x34.buildResultCode((byte) 0x34, Iso14229Serv0x34.NEGATIVE_RESPONSE, (byte) 0x78), resultCode);
    }

    // Similar test cases can be added for executeDiagnosticService() method
}
