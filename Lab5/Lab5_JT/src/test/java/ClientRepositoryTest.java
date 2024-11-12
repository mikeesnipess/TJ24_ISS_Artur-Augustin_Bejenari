import com.example.lab5_jt.Client;
import com.example.lab5_jt.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ClientRepositoryTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        em = emf.createEntityManager();
        clientRepository = new ClientRepository();
        clientRepository.setEntityManager(em);

        // Begin a new transaction before each test if one isn't already active
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    @Test
    public void testAddClient() {
        Client client = new Client("John Doe", "john@example.com", "555-1234", "123 Elm St");
        clientRepository.addClient(client);

        // Fetch the client after adding
        Client fetchedClient = clientRepository.findClient(client.getId());
        assertNotNull(fetchedClient);
        assertEquals("John Doe", fetchedClient.getName());
        assertEquals("john@example.com", fetchedClient.getEmail());

        // Commit the transaction to persist changes
        em.getTransaction().commit();
    }

    @Test
    public void testFindAllClients() {
        Client client1 = new Client("John Doe", "john@example.com", "555-1234", "123 Elm St");
        Client client2 = new Client("Jane Smith", "jane@example.com", "555-5678", "456 Oak St");

        clientRepository.addClient(client1);
        clientRepository.addClient(client2);

        List<Client> clients = clientRepository.findAllClients();
        assertNotNull(clients);
        assertEquals(2, clients.size());
    }
    @Test
    public void testFindClientByName() {
        // Arrange
        Client client = new Client("John Doe", "john@example.com", "555-1234", "123 Elm St");
        clientRepository.addClient(client);

        // Act
        Client fetchedClient = clientRepository.findClientByName("John Doe");

        // Assert
        assertNotNull(fetchedClient);
        assertEquals("john@example.com", fetchedClient.getEmail());
    }

    @Test
    public void testUpdateClient() {
        // Arrange
        Client client = new Client("John Doe", "john@example.com", "555-1234", "123 Elm St");
        clientRepository.addClient(client);

        // Act
        client.setName("John Updated");
        clientRepository.updateClient(client);

        // Assert
        Client updatedClient = clientRepository.findClient(client.getId());
        assertNotNull(updatedClient);
        assertEquals("John Updated", updatedClient.getName());
    }

    @Test
    public void testDeleteClient() {
        // Arrange
        Client client = new Client("John Doe", "john@example.com", "555-1234", "123 Elm St");
        clientRepository.addClient(client);
        UUID clientId = client.getId();

        // Act
        clientRepository.deleteClient(clientId);

        // Assert
        Client deletedClient = clientRepository.findClient(clientId);
        assertNull(deletedClient);
    }

    @AfterEach
    public void tearDown() {
        // Rollback the transaction after each test to clean up the database
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
