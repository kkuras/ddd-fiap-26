package equacao;

public class Equacao {
    int coeA;
    int coeB;
    int coeC;
    int delta;

    public int calcDelta() {
        delta = (coeB * coeB) - 4 * coeA *coeC;
        return delta;
    }
    public String raiz() {
        if (delta < 0){
            return "Nao existe raiz real";
        } else if (delta == 0) {
            return "Existe uma raiz real";
        } else {
            return "Existem duas raizes reais";
        }
    }
}
