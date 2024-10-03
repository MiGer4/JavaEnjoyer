package lab1;

import java.util.Objects;

import lombok.Getter;

@Getter
public class Characteristics {
    private float diagonal;
    private int ram;
    private int buildInMemoryGB;
    private String processor;
    private int megaPixels;
    private String color;
    private int mass;
    private int dB;
    private int autonomy;
    private String additionally;

    private Characteristics(float diagonal, int ram, int buildInMemoryGB, String processor, int megaPixels,
            String color, int mass, int dB, int autonomy, String additionally) {
        this.diagonal = diagonal;
        this.ram = ram;
        this.buildInMemoryGB = buildInMemoryGB;
        this.processor = processor;
        this.megaPixels = megaPixels;
        this.color = color;
        this.mass = mass;
        this.dB = dB;
        this.autonomy = autonomy;
        this.additionally = additionally;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Characteristics characteristics = (Characteristics) o;
        return diagonal == characteristics.diagonal && ram == characteristics.ram &&
                buildInMemoryGB == characteristics.buildInMemoryGB &&
                processor.equals(characteristics.processor) && megaPixels == characteristics.megaPixels &&
                color.equals(characteristics.color) && mass == characteristics.mass && dB == characteristics.dB &&
                autonomy == characteristics.autonomy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonal, ram, buildInMemoryGB, processor,
                megaPixels, color, mass, dB, autonomy);
    }

    @Override
    public String toString() {
        return "Characteristics{" +
                "diagonal=" + diagonal +
                ", ram=" + ram +
                ", buildInMemoryGB=" + buildInMemoryGB +
                ", processor=" + processor +
                ", megaPixels=" + megaPixels +
                ", color=" + color +
                ", mass=" + mass +
                ", dB=" + dB +
                ", autonomy=" + autonomy +
                ", additionally=" + additionally +
                "}";
    }

    public static class CharacteristicsBuilder {

        private float diagonal;
        private int ram;
        private int buildInMemoryGB;
        private String processor;
        private int megaPixels;
        private String color;
        private int mass;
        private int dB;
        private int autonomy;
        private String additionally;

        public CharacteristicsBuilder diagonal(float diagonal) {
            this.diagonal = diagonal;
            return this;
        }

        public CharacteristicsBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public CharacteristicsBuilder buildInMemoryGB(int buildInMemoryGB) {
            this.buildInMemoryGB = buildInMemoryGB;
            return this;
        }

        public CharacteristicsBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public CharacteristicsBuilder megaPixels(int megaPixels) {
            this.megaPixels = megaPixels;
            return this;
        }

        public CharacteristicsBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CharacteristicsBuilder mass(int mass) {
            this.mass = mass;
            return this;
        }

        public CharacteristicsBuilder dB(int dB) {
            this.dB = dB;
            return this;
        }

        public CharacteristicsBuilder autonomy(int autonomy) {
            this.autonomy = autonomy;
            return this;
        }

        public CharacteristicsBuilder additionally(String additionally) {
            this.additionally = additionally;
            return this;
        }

        private Characteristics build() {
            return new Characteristics(diagonal, ram, buildInMemoryGB, processor, megaPixels, color, mass, dB,
                    autonomy, additionally);
        }

        public Characteristics buildTelephone(float diagonal, int ram, int buildInMemoryGB, String processor,
                int megaPixels, String color, int mass, String additionally) {
            this.diagonal = diagonal;
            this.ram = ram;
            this.buildInMemoryGB = buildInMemoryGB;
            this.processor = processor;
            this.megaPixels = megaPixels;
            this.color = color;
            this.mass = mass;
            this.dB = 0;
            this.autonomy = 0;
            this.additionally = additionally;
            return build();
        }

        public Characteristics buildEarphone(String color, int mass, int dB, int autonomy,
                String additionally) {
            this.diagonal = 0;
            this.ram = 0;
            this.buildInMemoryGB = 0;
            this.processor = "";
            this.megaPixels = 0;
            this.color = color;
            this.mass = mass;
            this.dB = dB;
            this.autonomy = autonomy;
            this.additionally = additionally;
            return build();
        }

        public Characteristics buildColumn(String color, int mass, int dB, int autonomy,
                String additionally) {
            this.diagonal = 0;
            this.ram = 0;
            this.buildInMemoryGB = 0;
            this.processor = "";
            this.megaPixels = 0;
            this.color = color;
            this.mass = mass;
            this.dB = dB;
            this.autonomy = autonomy;
            this.additionally = additionally;
            return build();
        }
    }
}
