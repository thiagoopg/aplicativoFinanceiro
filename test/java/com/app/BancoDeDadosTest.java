import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoDeDadosTest {

    private BancoDeDados bancoDeDados;
    private Map<Integer, Entrada> bancoMock;

    @BeforeEach
    public void setUp(){
        // Cria um mock do Map
        bancoMock = mock(Map.class);
        
        // Inicializa a classe BancoDeDados, passando o mock
        bancoDeDados = new BancoDeDados();
    }
    @Test
    public void testAddEntrada() {
        // Definir dados para o teste
        String nome = "Salário";
        double valor = 1000;
        int dia = 15;
        int mes = 5;
        int ano = 2024;
        boolean status = true;

        // Executar o método addEntrada
        bancoDeDados.addEntrada(nome, valor, dia, mes, ano, status);

        // Verificar se o método put foi chamado no banco de dados mockado
        verify(bancoMock).put(anyInt(), any(Entrada.class));
        
        // Não podemos verificar diretamente o HashMap interno porque ele está encapsulado
        // Mas podemos confirmar que o método put foi chamado
    }
    @Test
    void testRemoveEntradaRemoveCorretamente() {
        // Cria um mock do banco de dados
        BancoDeDados bancoDeDados = new BancoDeDados();

        // Adiciona uma entrada ao banco de dados
        bancoDeDados.addEntrada("mercado", 200.0, 15, 12, 2024, false);

        // Verifica que o banco contém 1 entrada antes da remoção
        assertEquals(1, bancoDeDados.getBanco().size(), "O banco deveria ter uma entrada.");

        // Chama o método removeEntrada para remover a entrada com o ID 1
        bancoDeDados.removeEntrada(1);

        // Verifica se o banco de dados ficou vazio após a remoção
        assertEquals(0, bancoDeDados.getBanco().size(), "A entrada não foi removida corretamente.");
    }
}
