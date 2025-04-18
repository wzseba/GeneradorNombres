package generador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.github.javafaker.Faker;

public class GeneradorNombres {

	public static void generadorNom() throws IOException {

		int cantidadNombres = 5;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.in"))) {

			writer.write(Integer.toString(cantidadNombres));
			writer.newLine();

			Random random = new Random();
			Faker faker = new Faker();

			for (int i = 0; i < cantidadNombres; i++) {
				int id = random.nextInt(450) + 1;
				String nombre = faker.name().firstName();
				String apellido = faker.name().lastName();

				writer.write(id + " " + nombre + " " + apellido);

				if (i < cantidadNombres - 1) {
					writer.newLine();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		generadorNom();
	}
}
