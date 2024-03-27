import com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x31;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Iso14229Serv0x31Test {

    private Iso14229Serv0x31 iso14229Serv0x31;
    private ServiceInfo mockServiceInfo;
    private Iso15765TpInterface mockUdsInterface;

    @Before
    public void setUp() {
        mockServiceInfo = mock(ServiceInfo.class);
        mockUdsInterface = mock(Iso15765TpInterface.class);
        iso14229Serv0x31 = new Iso14229Serv0x31(mockServiceInfo, mockUdsInterface);
    }

    @Test
    public void testBuildRequestFrame_EraseMemory() {
        when(mockServiceInfo.getRoutineIdentifierValue()).thenReturn(Iso14229Serv0x31.ERASE_MEMORY);
        byte[] requestFrame = iso14229Serv0x31.buildRequestFrame();
        assertEquals(5, requestFrame.length);
        assertEquals(0x31, requestFrame[0]);
        assertEquals(0x01, requestFrame[1]); // Subfunction ID for erase memory
        assertEquals((byte) 0xff, requestFrame[2]);
        assertEquals((byte) 0x00, requestFrame[3]);
        assertEquals((byte) 0x00, requestFrame[4]);
    }

    @Test
    public void testBuildRequestFrame_ChecksumCalculation() {
        when(mockServiceInfo.getRoutineIdentifierValue()).thenReturn(Iso14229Serv0x31.CHECKSUM_CALCULATION);
        when(mockServiceInfo.getFirmwareProgramFile()).thenReturn(mock(FirmwareProgramFile.class));
        when(mockServiceInfo.getFirmwareProgramFile().getCalculateCRC32()).thenReturn(123456789L);
        byte[] requestFrame = iso14229Serv0x31.buildRequestFrame();
        assertEquals(8, requestFrame.length);
        assertEquals(0x31, requestFrame[0]);
        assertEquals(0x01, requestFrame[1]); // Subfunction ID for checksum calculation
        assertEquals((byte) 0xff, requestFrame[2]);
        assertEquals((byte) 0x01, requestFrame[3]);
        assertEquals((byte) 0x07, requestFrame[4]); // Checksum byte 1
        assertEquals((byte) 0x5B, requestFrame[5]); // Checksum byte 2
        assertEquals((byte) 0xCD, requestFrame[6]); // Checksum byte 3
        assertEquals((byte) 0x15, requestFrame[7]); // Checksum byte 4
    }

    @Test
    public void testProcessResponse_PositiveResponse() {
        byte[] rxFrame = {(byte) 0x71}; // Positive Response
        int resultCode = iso14229Serv0x31.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x31.buildResultCode((byte) 0x31, Iso14229Serv0x31.SUCCESS, (byte) 0), resultCode);
    }

    @Test
    public void testProcessResponse_NegativeResponse() {
        byte[] rxFrame = {(byte) 0x7F, (byte) 0x31}; // Negative Response: RequestOutOfRange
        int resultCode = iso14229Serv0x31.processResponse(rxFrame);
        assertEquals(Iso14229Serv0x31.buildResultCode((byte) 0x31, Iso14229Serv0x31.NEGATIVE_RESPONSE, (byte) 0x31), resultCode);
    }

    // Similar test cases can be added for executeDiagnosticService() method
}
