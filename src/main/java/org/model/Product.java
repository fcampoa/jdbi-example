package org.model;

public record Product(int id, String name, double price, String brand, String barcode) {
    public static class Builder {
        private int id;
        private String name;
        private double price;
        private String brand;
        private String barcode;
        public Builder() { }

        public Builder(int id, String name, double price, String brand, String barcode) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.brand = brand;
            this.barcode = barcode;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder price(double price) {
            this.price = price;
            return this;
        }
        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }
        public Builder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }
        public Product build() {
            return new Product(id, name, price, brand, barcode);
        }
    }
}
