package weather;


	import javafx.application.Application;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.image.*;
	import javafx.scene.layout.*;
	import javafx.stage.Stage;

	public class WeatherApp extends Application {

	    private Label cityLabel = new Label("Enter City:");
	    private TextField cityInput = new TextField();
	    private Button searchButton = new Button("Search");
	    private Label resultLabel = new Label();
	    private ImageView weatherIcon = new ImageView();

	    @Override
	    public void start(Stage primaryStage) {
	        VBox layout = new VBox(10);
	        layout.setPadding(new Insets(20));

	        HBox inputBox = new HBox(10, cityLabel, cityInput, searchButton);
	        layout.getChildren().addAll(inputBox, resultLabel, weatherIcon);

	        searchButton.setOnAction(e -> fetchWeather());

	        Scene scene = new Scene(layout, 400, 250);
	        primaryStage.setTitle("Weather Forecast App");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	    private void fetchWeather() {
	        String city = cityInput.getText().trim();
	        if (city.isEmpty()) {
	            resultLabel.setText("Please enter a city name.");
	            return;
	        }

	        try {
	            WeatherResponse weather = WeatherService.getWeather(city);
	            if (weather != null) {
	                resultLabel.setText(String.format(
	                        "City: %s\nTemperature: %.2f°C\nWeather: %s",
	                        weather.name,
	                        weather.main.temp - 273.15,  // Kelvin to Celsius
	                        weather.weather[0].description
	                ));

	                String iconUrl = "https://openweathermap.org/img/wn/" + weather.weather[0].icon + "@2x.png";
	                weatherIcon.setImage(new Image(iconUrl));
	            } else {
	                resultLabel.setText("City not found or API error.");
	                weatherIcon.setImage(null);
	            }
	        } catch (Exception e) {
	            resultLabel.setText("Error: " + e.getMessage());
	            weatherIcon.setImage(null);
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}


}
