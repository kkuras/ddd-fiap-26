package br.com.fiap.streaming.enums;

public enum ClassificacaoEnum {
    LIVRE,
    DOZE,
    QUATORZE,
    DEZESSEIS,
    DEZOITO;

    public int getClassificacao() {
        return switch (this) {
            case LIVRE      -> 0;
            case DOZE       -> 12;
            case QUATORZE   -> 14;
            case DEZESSEIS  -> 16;
            case DEZOITO    -> 18;
        };
    }
}
