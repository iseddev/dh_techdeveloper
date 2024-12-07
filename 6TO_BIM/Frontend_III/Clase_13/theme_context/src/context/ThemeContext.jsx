import { createContext } from "react";

// Importing the themes object from the theming file
import { themes } from "../data/theming";

// Creating a ThemeContext object with the default value of the light theme
const ThemeContext = createContext(themes.light);

export default ThemeContext;
