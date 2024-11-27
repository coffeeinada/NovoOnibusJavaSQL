import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Passageiro {
    private int idPassageiro;
    private String nome;
    private String documentoIdentidade;

    public Passageiro() {}

    public Passageiro(int idPassageiro, String nome, String documentoIdentidade) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.documentoIdentidade = documentoIdentidade;
    }

    // Getters e Setters
    public int getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        this.idPassageiro = idPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoIdentidade() {
        return documentoIdentidade;
    }

    public void setDocumentoIdentidade(String documentoIdentidade) {
        this.documentoIdentidade = documentoIdentidade;
    }
}
