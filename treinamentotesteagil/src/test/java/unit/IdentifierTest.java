package unit;

import net.vanilton.Identifier;
import org.junit.*;

public class IdentifierTest {

    Identifier id;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class");
    }

    @Before
    public void setUp(){
        id = new Identifier();
    }

    @Test
    public void verificarIdentificadorVazio(){
        Assert.assertFalse(id.validateIdentifier(""));
    }

    @Test
    public void verificarIdentificadorEspacoVazio(){
        Assert.assertFalse(id.validateIdentifier(" "));
    }

    @Test
    public void verificarIdentificadorNulo(){
        Assert.assertFalse(id.validateIdentifier(null));
    }

    @Test
    public void verificarIdentificadorComCaracterEspecial(){
        Assert.assertFalse(id.validateIdentifier("@12345"));
    }

    @Test
    public void verificarIdentificadorComOMinimoDeCaracteresValidos(){
        Assert.assertTrue(id.validateIdentifier("Z"));
    }

    @Test
    public void verificarIdentificadorComOMaximoDeCaracteresValidos(){
        Assert.assertTrue(id.validateIdentifier("a12345"));
    }

    @Test
    public void verificarIdentificadorComQuantidadeCaracteresAcimaDoLimite(){
        Assert.assertTrue(id.validateIdentifier("a12345"));
    }

    @Test
    public void verificarIdentificadorComecandoComUmaLetra(){
       Assert.assertTrue("Falhou retornando diferente de true", id.validateIdentifier("a"));
    }

    @Test
    public void verificarIdentificadorComecandoComUmNumero(){
        Assert.assertFalse("Falhou retornando diferente de true", id.validateIdentifier("1"));
    }

    @After
    public void tearDown(){
        //id = null;
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("After Class");
    }

}
