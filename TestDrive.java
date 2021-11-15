import java.time.LocalDate;
import java.util.Date;

public class TestDrive {

    private LocalDate data;
    private String cpfCliente;
    private String carroPlaca;

    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            ", cpfCliente='" + getCpfCliente() + "'" +
            ", carroPlaca='" + getCarroPlaca() + "'" +
            "}";
    }

    public TestDrive(LocalDate data, String cpfCliente, String carroPlaca) {
        this.data = data;
        this.cpfCliente = cpfCliente;
        this.carroPlaca = carroPlaca;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCarroPlaca() {
        return this.carroPlaca;
    }

    public void setCarroPlaca(String carroPlaca) {
        this.carroPlaca = carroPlaca;
    }


    
}
