package br.maua.enumeracoes;

public enum Status {
    PLATINADO{
        @Override
        public String toString() {
            return "Platinado";
        }
    },
    NAO_INICIADO{
        @Override
        public String toString() {
            return "Não iniciado";
        }
    },
    TERMINADO{
        @Override
        public String toString() {
            return "Terminado";
        }
    },
    JOGANDO{
        @Override
        public String toString() {
            return "Jogando";
        }
    },
    ABANDONADO{
        @Override
        public String toString() {
            return "Abandonado";
        }
    };
}