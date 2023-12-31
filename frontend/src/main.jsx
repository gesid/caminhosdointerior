import React from "react";
import ReactDOM from "react-dom/client";
import GlobalStyle from "./styles/globalStyles";
import { RouterProvider } from "react-router-dom";
import { route } from "./routes";
import { ThemeProvider } from "styled-components";
import { theme } from "./themes";

import { CurrentStepProvider } from "./context/CurrentStep.context.";
import { SidebarProvider } from "./context/Sidebar.context";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <CurrentStepProvider>
      <SidebarProvider>
        <ThemeProvider theme={theme}>
          <GlobalStyle />
          <RouterProvider router={route} />
        </ThemeProvider>
      </SidebarProvider>
    </CurrentStepProvider>
  </React.StrictMode>
);
