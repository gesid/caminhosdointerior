import { useEffect } from "react";
import { StyledForm } from "./style";
import { StyledLableTitle } from "./style";
import { StyledContactField } from "./style";
import { StyledContactField2 } from "./style";
import { StyledMainDiv } from "./style";
import { StyledButton } from "./style";
import { api } from "../../services/api";
import { useState } from "react";
import { StyledTitleWithImage } from "./style";

export const Form = () => {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");

    async function saveFeedbacks() {
        const response = await api.post("/api/feedbacks", {
            email: email,
            message: message,
            name: name,
            surname: surname
        });
        alert("Mensagem enviada com sucesso!");
    }

    return (
        <div>
            <StyledMainDiv>
                <StyledTitleWithImage>
                <h6>
                    Entre em contato
                </h6>
                <img src="src/assets/cacto.svg" alt="Imagem cacto"></img>
                </StyledTitleWithImage>
            <StyledLableTitle/>
            <StyledForm>
                <strong>Agradecemos seu feedback!</strong> Vamos considerar suas sugestões para melhorar
                nossa plataforma. Obrigado por nos ajudar a oferecer uma experiência ainda
                melhor no turismo pelo interior do Nordeste.
            </StyledForm>
            <StyledContactField>
                <div className="NameFields">
                    <div className="FieldContainer">
                        <div className="LabelTextField">
                            Nome
                        </div>
                        <div className="BorderContactNameField">
                            <input
                                type="text" value={name} className="TextField"
                                placeholder="Digite seu nome" onChange={(event) => setName(event.target.value)} />
                        </div>
                    </div>
               <div className="FieldContainer">
                
                        <div className="LabelTextField">
                            Sobrenome
                        </div>
                        <div className="BorderContactNameField">
                            <input
                                type="text" value={surname} className="TextField"
                                placeholder="Digite seu sobrenome" onChange={(event) => setSurname(event.target.value)} />
                        </div>
                    </div>
                </div>
            </StyledContactField>
            <StyledContactField2>
                <div className="NameFields">
                    <div className="FieldContainer">
                        <div className="LabelTextFieldMessage">
                            Email
                        </div>
                        <div className="BorderEmailField">
                            <input
                                type="email" value={email} className="TextField"
                                placeholder="Digite seu email" onChange={(event) => setEmail(event.target.value)} />
                        </div>
                    </div>
                </div>
            </StyledContactField2>
            <StyledContactField2>
                <div className="NameFields">
                    <div className="FieldContainer">
                        <div className="LabelTextFieldMessage">
                            Mensagem
                        </div>
                        <div className="BorderContactMessageField">
                            <input
                                type="text" value={message} className="TextField"
                                placeholder="Digite sua mensagem" onChange={(event) => setMessage(event.target.value)} />
                        </div>
                    </div>
                </div>
            </StyledContactField2 >
            <StyledButton>
                <button onClick={saveFeedbacks} className="CustomButton">Enviar</button>
            </StyledButton>
            </StyledMainDiv>
        </div >
    );
}