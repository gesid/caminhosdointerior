import { createBrowserRouter } from "react-router-dom";
import { Home } from "../pages/Home";
import { Page404 } from "../pages/404";
import { OndeIr } from "../pages/OndeIr";

export const route = createBrowserRouter([
  {
    path: "*",
    element: <Page404 />,
  },
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/ondeIr",
    element: <OndeIr />,
  },
]);
