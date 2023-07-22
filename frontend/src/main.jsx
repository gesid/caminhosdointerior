import React from "react";
import ReactDOM from "react-dom/client";
import GlobalStyle from "./styles/globalStyles";
import { RouterProvider } from "react-router-dom";
import { route } from "./routes";
import { Header } from "./components/Header";
import { ThemeProvider } from "styled-components";
import { theme } from "./themes";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Header />
      <RouterProvider router={route} />
    </ThemeProvider>
  </React.StrictMode>
);
