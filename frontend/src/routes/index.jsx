import { createBrowserRouter } from "react-router-dom";
import { Home } from "../pages/Home";
import { Page404 } from "../pages/404";
import { Contact } from "../pages/Contact";
import {OndeIr} from "../pages/OndeIr";
import { OQueFazer } from "../pages/OQueFazer";

export const route = createBrowserRouter([
  {
    path: "o-que-fazer",
    element: <OQueFazer />
  },
  {
    path: "/contact",
    element: <Contact />,
  },
  {
    path: "/page404",
    element: <Page404 />,
  },
  {
    path: "/ondeIr",
    element: <OndeIr />,
  },
  {
    path: "/",
    element: <Home />,
  }
]);
