package Atividade1;
public class PontoCartesiano {
    
        private double xA, yA, xB, yB;
    
        public PontoCartesiano(double xA, double yA, double xB, double yB) {
    
            this.xA = xA;
            this.yA = yA;
            this.xB = xB;
            this.yB = yB;
        }
    
        public double getxA() {
            return xA;
        }
    
        public void setxA(double xA) {
            this.xA = xA;
        }
    
        public double getyA() {
            return yA;
        }
    
        public void setyA(double yA) {
            this.yA = yA;
        }
    
        public double getxB() {
            return xB;
        }
    
        public void setxB(double xB) {
            this.xB = xB;
        }
    
        public double getyB() {
            return yB;
        }
    
        public void setyB(double yB) {
            this.yB = yB;
        }
    
        public double distance() {
            
            return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    
        }
    }
    
