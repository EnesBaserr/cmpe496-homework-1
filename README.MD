# Drawing Editor Homework-1

- **Author**: **Enes Baser - 2020400141**

- For preview image , please check the **editor.png** file in the root directory.
## System Requirements

- **Operating System**: Windows, macOS, or Linux
- **Java Development Kit (JDK)**: Version 8 or higher
- **Maven**: Version 3.6.0 or higher

## Setup Instructions


1**Install dependencies**:
    ```
    mvn clean install
    ```

2**Run the application**:
    ```
    mvn javafx:run
    ```

## How to Use

1. **Add Shapes**:
    - Use the toolbar buttons to add circles, squares, and lines to the drawing panel.
    - Shapes will be added at random positions within the drawing panel.

2. **Erase Shapes**:
    - Select a shape by clicking on it.
    - Click the "Erase" button in the toolbar to remove the selected shape.

## Project Structure

- `src/main/java/com/drawingeditor/`: Contains the main application and utility classes.
- `src/main/java/com/drawingeditor/panel/`: Contains the `DrawingPanel` class for drawing shapes.
- `src/main/java/com/drawingeditor/button/`: Contains the `ToolbarButton` class for creating toolbar buttons.
- `src/main/java/com/drawingeditor/model/`: Contains shape model classes like `Circle`, `Square`, and `Line`.
- `pom.xml`: Maven configuration file.

## Dependencies

- **Maven**: Used for project management and dependency management.

