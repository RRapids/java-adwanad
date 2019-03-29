package shili2;

interface DrawImage {
    public void draw();
}

class Rectangle implements DrawImage {
    public void draw() {
        System.out.println("画矩形");
    }
}

class Square implements DrawImage {
    public void draw() {
        System.out.println("画正方形");
    }
}

class Diamond implements DrawImage {
    public void draw() {
        System.out.println("画菱形");
    }
}
