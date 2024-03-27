import com.royalenfield.diagcan.Iso14229UdsClient.FirmwareProgramFile;
import com.royalenfield.diagcan.Iso14229UdsClient.ServiceInfo;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsDiagnosticService;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsSession;
import com.royalenfield.diagcan.UdsCallbackEventManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UdsSessionTest {

    private UdsSession udsSession;
    private FirmwareProgramFile mockFirmwareProgramFile;
    private ServiceInfo mockServiceInfo;

    @Mock
    private UdsCallbackEventManager mockCallbackMgr;

    @Before
    public void setUp() {
        udsSession = new UdsSession(null); // Pass null context for testing
        mockFirmwareProgramFile = mock(FirmwareProgramFile.class);
        mockServiceInfo = mock(ServiceInfo.class);
        udsSession.callbackMgr = mockCallbackMgr;
    }

    @Test
    public void testParseServiceDiscoveryFile_WithValidXml() throws IOException {
        String xmlContent = "<service><id>0x01</id><name>Service 1</name></service>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());

        Queue<ServiceInfo> serviceInfoQueue = udsSession.parseServiceDiscoveryFile(null, mockFirmwareProgramFile);

        assertNotNull(serviceInfoQueue);
        assertEquals(0, serviceInfoQueue.size());
    }

    @Test(expected = IOException.class)
    public void testParseServiceDiscoveryFile_WithInvalidXml() throws IOException {
        String xmlContent = "<invalid_xml>"; // Invalid XML content
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());

        Queue<ServiceInfo> serviceInfoQueue = udsSession.parseServiceDiscoveryFile(null, mockFirmwareProgramFile);
    }

    @Test
    public void testExecuteServices_SuccessfulExecution() {
        UdsDiagnosticService mockService1 = mock(UdsDiagnosticService.class);
        UdsDiagnosticService mockService2 = mock(UdsDiagnosticService.class);

        Mockito.when(mockService1.executeDiagnosticService()).thenReturn(0);
        Mockito.when(mockService2.executeDiagnosticService()).thenReturn(0);

        LinkedList<UdsDiagnosticService> serviceList = new LinkedList<>();
        serviceList.add(mockService1);
        serviceList.add(mockService2);

        int resultCode = udsSession.executeServices(serviceList);

        assertEquals(0, resultCode);
        Mockito.verify(mockCallbackMgr, Mockito.times(2)).log(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(mockCallbackMgr, Mockito.never()).onError(Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void testExecuteServices_FailureInExecution() {
        UdsDiagnosticService mockService1 = mock(UdsDiagnosticService.class);
        UdsDiagnosticService mockService2 = mock(UdsDiagnosticService.class);

        Mockito.when(mockService1.executeDiagnosticService()).thenReturn(0);
        Mockito.when(mockService2.executeDiagnosticService()).thenReturn(0x02000001); // Simulate failure with result code

        LinkedList<UdsDiagnosticService> serviceList = new LinkedList<>();
        serviceList.add(mockService1);
        serviceList.add(mockService2);

        int resultCode = udsSession.executeServices(serviceList);

        assertEquals(0x02000001, resultCode);
        Mockito.verify(mockCallbackMgr, Mockito.times(1)).log(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(mockCallbackMgr, Mockito.times(1)).onError(Mockito.anyInt(), Mockito.anyString());
    }
}
