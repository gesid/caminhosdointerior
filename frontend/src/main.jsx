import React from "react";
import ReactDOM from "react-dom/client";
import GlobalStyle from "./styles/globalStyles";
import { RouterProvider } from "react-router-dom";
import { route } from "./routes";
import { ThemeProvider } from "styled-components";
import { theme } from "./themes";

import { NavBar } from "./components/NavBar";
import { CurrentStepProvider } from "./context/CurrentStep.context.";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <CurrentStepProvider>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <NavBar />
        <RouterProvider router={route} />
      </ThemeProvider>
    </CurrentStepProvider>
  </React.StrictMode>
);
