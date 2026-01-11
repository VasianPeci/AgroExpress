import { createTheme } from "@mui/material";

const customeTheme = createTheme({
  palette: {
    mode: "light", // This sets the theme to dark mode
    primary: {
      main: "#4CAF50", // Green for agricultural theme
    },
    secondary: {
      main: "#8D6E63", // Brown for earthy feel
    },
  },
});

export default customeTheme;
