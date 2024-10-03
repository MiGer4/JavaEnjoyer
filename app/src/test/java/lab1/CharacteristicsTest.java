package lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacteristicsTest {
    Characteristics chPhone;
    Characteristics chEarphones;

    @BeforeEach
    void beforeEach() {
        chPhone = new Characteristics.CharacteristicsBuilder().buildTelephone(6.6f, 8, 256, "Samsung Exynos 1480", 50,
                "Lilac", 213, "IOOOOU");
        chEarphones = new Characteristics.CharacteristicsBuilder().buildEarphone("White", 9, 60, 30,
                "IOOOOU");
    }

    @Test
    void stringRepresentationTest() {
        String exceptedPhone = "Characteristics{diagonal=6.6, ram=8, buildInMemoryGB=256, processor=Samsung Exynos 1480, megaPixels=50, color=Lilac, mass=213, dB=0, autonomy=0, additionally=IOOOOU}";
        String exceptedEarphones = "Characteristics{diagonal=0.0, ram=0, buildInMemoryGB=0, processor=, megaPixels=0, color=White, mass=9, dB=60, autonomy=30, additionally=IOOOOU}";
        assertEquals(chPhone.toString(), exceptedPhone);
        assertEquals(chEarphones.toString(), exceptedEarphones);
    }
}
