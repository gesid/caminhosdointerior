import { createContext, useContext, useReducer } from "react";

const INITIAL_STATE = {
  sertao: "",
  evento: "",
  texto: "",
  cidade: ""
};

const sidebarContext = createContext();

export const actionTypes = {
  UPDATE_SERTAO: "UPDATE_SERTAO",
  UPDATE_EVENTO: "UPDATE_EVENTO",
  UPDATE_TEXTO: "UPDATE_TEXTO",
  UPDATE_CIDADE: "UPDATE_CIDADE"
};

const sidebarReducer = (state, action) => {
  switch (action.type) {
    case actionTypes.UPDATE_SERTAO:
      return { ...state, sertao: action.payload };
    case actionTypes.UPDATE_EVENTO:
      return { ...state, evento: action.payload };
    case actionTypes.UPDATE_CIDADE:
      return {...state, cidade: action.payload}
    default:
      return state;
  }
};

export const useSidebar = () => {
  const context = useContext(sidebarContext);

  if (!context)
    throw new Error("useSidebar must be used within Sidebar Context");

  return context;
};

export const SidebarProvider = (props) => {
  const [state, dispatch] = useReducer(sidebarReducer, INITIAL_STATE);

  return (
    <sidebarContext.Provider value={{ state, dispatch }}>
      {props.children}
    </sidebarContext.Provider>
  );
};
