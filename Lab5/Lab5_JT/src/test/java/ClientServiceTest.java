
import com.example.lab5_jt.Client;
import com.example.lab5_jt.ClientService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {

    private final ClientService clientService = new ClientService();

    @Test
    public void testAddClient() {
        clientService.addClient("John Doe", "john@example.com");
        Client client = clientService.findClient(1L);
        assertNotNull(client);
        assertEquals("John Doe", client.getName());
    }
}
