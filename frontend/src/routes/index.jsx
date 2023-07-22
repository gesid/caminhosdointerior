import { createBrowserRouter } from "react-router-dom";
import { Home } from "../pages/Home";
import { Page404 } from "../pages/404";

export const route = createBrowserRouter([
  {
    path: "*",
    element: <Page404 />,
  },
  {
    path: "/",
    element: <Home />,
  },
]);
