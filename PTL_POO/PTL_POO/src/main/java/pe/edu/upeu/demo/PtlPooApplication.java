package pe.edu.upeu.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PtlPooApplication extends Application {

	private ConfigurableApplicationContext context;
	private Parent parent;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PtlPooApplication.class);
		builder.application().setWebApplicationType(WebApplicationType.NONE);
		context = builder.run(getParameters().getRaw().toArray(new String[0]));

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/form_mngareas.fxml"));
		loader.setControllerFactory(context::getBean);
		parent = loader.load();
	}

	@Override
	public void start(Stage stage) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setScene(new Scene(parent, bounds.getWidth() - 200, bounds.getHeight() - 200));
		stage.setTitle("Gestión de Áreas");
		stage.show();
	}

	@Override
	public void stop() {
		context.close();
	}
}

