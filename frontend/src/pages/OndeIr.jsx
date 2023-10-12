import { SideBar } from "../components/Sidebar";
import { EventCard } from "../components/EventCard";
import * as S from "../styles/ondeIrStyles";
import { useEffect } from "react";
import { useCurrentStep } from "../context/CurrentStep.context.";
import { NavBar } from "../components/NavBar";
import Footer from "../components/footer/Footer";

export const OndeIr = () => {
  const [_currentStep, setCurrentStep] = useCurrentStep();

  useEffect(() => {
    setCurrentStep(2);
  }, []);

  return (
    <>
      <NavBar />
      <S.Container>
        <SideBar />
        <S.Content>
          <h3>Resultados da pesquisa</h3>
          <S.Events>
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />{" "}
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Igreja_Matriz_de_Crate%C3%BAs.JPG/800px-Igreja_Matriz_de_Crate%C3%BAs.JPG"
              name="Paraça da matriz"
            />
            <EventCard
              category="CULINARIO"
              city={{
                name: "Crateus",
                sertao: "Inhamus",
              }}
              image="https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTZm0Elodyz3SjOtENXwymrdLLSAxY8utgyT1YAkK8NvNTBqdBpSmyAS5ur6GsYZ4_8lhJuunIVJWzkiXlk9QfX4EDl22oN"
              name="Paraça da matriz"
            />
          </S.Events>
        </S.Content>
      </S.Container>
      <Footer />
    </>
  );
};
