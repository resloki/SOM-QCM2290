package com.royalenfield.diagcan.iso15765TP;

public class CanConfig {
    private CanIds canIds;
    private CanTp canTp;

    public CanIds getCanIds() {
        return canIds;
    }

    public void setCanIds(CanIds canIds) {
        this.canIds = canIds;
    }

    public CanTp getCanTp() {
        return canTp;
    }

    public void setCanTp(CanTp canTp) {
        this.canTp = canTp;
    }

    public static class CanIds {
        private int physical;
        private int functional;
        private int response;

        public int getPhysical() {
            return physical;
        }

        public void setPhysical(int physical) {
            this.physical = physical;
        }

        public int getFunctional() {
            return functional;
        }

        public void setFunctional(int functional) {
            this.functional = functional;
        }

        public int getResponse() {
            return response;
        }

        public void setResponse(int response) {
            this.response = response;
        }
    }

    public static class CanTp {
        private int timeoutMs;

        public int getStminTx() {
            return stminTx;
        }

        public void setStminTx(int stminTx) {
            this.stminTx = stminTx;
        }

        private int stminTx;

        public int getTimeoutMs() {
            return timeoutMs;
        }

        public void setTimeoutMs(int timeoutMs) {
            this.timeoutMs = timeoutMs;
        }

    }
}
