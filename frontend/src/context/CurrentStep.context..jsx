import { createContext, useContext, useState } from "react";

const stepContext = createContext([1, () => []]);

export const useCurrentStep = () => {
  const context = useContext(stepContext);

  if (!context)
    throw new Error("useCurrentStep must be used within Step Context ");

  return context;
};

export const CurrentStepProvider = (props) => {
  const [currentStep, setCurrentStep] = useState();

  return (
    <stepContext.Provider value={[currentStep, setCurrentStep]}>
      {props.children}
    </stepContext.Provider>
  );
};
