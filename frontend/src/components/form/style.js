import styled from 'styled-components';

export const StyledMainDiv = styled.div`
    margin-left:12rem;
    margin-right:12rem;
    margin-top:8rem;
`

export const StyledTitleWithImage = styled.div`
  display: flex;
  align-items: center;
  
  h6 {
        color: #000;
        font-family: Arial;
        font-size: 4.85rem;
        font-style: normal;
        font-weight: 900;
        line-height: 100%;
        letter-spacing: 0.021rem;
        text-transform: uppercase;
  }

  img {
    width: 6rem; 
    height: 6rem;
    margin-left: 1.25rem;
    margin-bottom:0.9rem
  };
`

export const StyledLableTitle = styled.div`
    flex-shrink: 0;
    width: 63rem;
    height: 1.25rem;
    flex-shrink: 0;
    border-radius: 0.31rem;
    background: var(--Laranja-New, #F5A42E);
    margin-top: -1rem;
    ;
`

export const StyledForm = styled.div`
    margin-left:4.37rem;
    margin-right:2.5rem;
    margin-top:0.5rem;
    margin-bottom:3rem;
    display: flex;
    width: 48rem;
    height: 7.81rem;
    flex-direction: column;
    justify-content: center;
    flex-shrink: 0; 
    
    h6{
        color: #000;
        font-family: Poppins;
        font-size:1.25rem;
        font-family: Poppins;
        font-style: normal;
        font-weight: 400;
        line-height: 0.93rem; /* 50% */
        letter-spacing: 0.009rem;
        
    }
    ;
`

export const StyledContactField = styled.div`
    width: 39.75rem;
    height: 8.56rem;
    flex-shrink: 0;
    margin-bottom:2rem;
    position: relative;
    display: flex;
    justify-content: space-between;
    flex-direction: column;
    
    .NameFields {
        display: flex;
        flex-direction: row;
        margin-bottom: 1.25rem;
        
        
        > .FieldContainer:first-child {
            margin-right: 1.25rem;
        }
    }
    
    .MessageField {
        display: flex;
        flex-direction: column;
        margin-bottom: 1.25rem;
    }

    .TextField{
        margin-top:0.93rem;
        margin-bottom:0.67rem;
        display: flex;
        width: 25rem;
        height: 3.82rem;
        flex-direction: column;
        justify-content: center;
        flex-shrink: 0;
        color: #000;
        font-family: Poppins;
        font-size: 1.56rem;
        font-style: italic;
        font-weight: 400;
        line-height: 0.62rem; /* 60% */
        letter-spacing: 0.031rem;
        border:none;
    }

    .LabelTextField{
        display: flex;
        width: 13.87rem;
        height: 3.125rem;
        flex-direction: column;
        justify-content: center;
        flex-shrink: 0;
        color: #000;
        text-align: center;
        font-family: Poppins;
        font-size: 1.56rem;
        font-style: normal;
        font-weight: 600;
        line-height: 0.93rem; /* 60% */
        letter-spacing: 0.031rem;
        background:#F5A42ECC;
        position: absolute;
        top: -2.18rem;
        margin-bottom:0.31rem;
        margin-left:2rem;
    }
    
    .BorderContactNameField{
        width: 30.5rem;
        height: 5.43rem;
        flex-shrink: 0;
        border-radius: 0.56rem;
        border: 4px solid var(--Laranja-Transparente, rgba(245, 164, 46, 0.80));
        position: relative;
    }   
`

export const StyledContactField2 = styled.div`
    width: 39.75rem;
    height: 8.56rem;
    flex-shrink: 0;
    margin-bottom: 2.5rem;
    position: relative;
    display: flex;
    justify-content: space-between;
    flex-direction: column;


    .NameFields {
        display: flex;
        flex-direction: column;
        
        > .FieldContainer:first-child {
            
        }
    }

    .TextField{
        margin-top:0.93rem;
        margin-bottom:0.67rem;
        display: flex;
        width: 55rem;
        height: 3.12rem;
        flex-direction: column;
        justify-content: center;
        flex-shrink: 0;
        color: #000;
        font-family: Poppins;
        font-size: 1.56rem;
        font-style: italic;
        font-weight: 400;
        line-height: 0.62rem; /* 60% */
        letter-spacing:0.031rem;
        border:none;
    }

    .LabelTextFieldMessage {
        display: flex;
        width: 13.87rem;
        height: 3.12rem;
        flex-direction: column;
        justify-content: center;
        flex-shrink: 0;
        color: #000;
        text-align: center;
        font-family: Poppins;
        font-size: 1.56rem;
        font-style: normal;
        font-weight: 600;
        line-height: 0.93rem; /* 60% */
        letter-spacing: 0.031rem;
        background: #F5A42ECC;
        position: absolute;
        top:-2.18rem;
        margin-bottom: 0.31rem;
        margin-left:2rem;
    }
    
    .BorderContactMessageField {
        width: 63rem;
        height: 24.56rem;
        flex-shrink: 0;
        border-radius: 0.56rem;
        border: 0.44rem solid var(--Laranja-Transparente, rgba(245, 164, 46, 0.80));
        position: relative;
        
    }

    .BorderEmailField {
        width: 63rem;
        height: 5.43rem;
        flex-shrink: 0;
        border-radius: 0.56rem;
        border: 0.25rem solid var(--Laranja-Transparente, rgba(245, 164, 46, 0.80));
        position: relative;
        margin-bottom: 2.5rem;
    }
`

export const StyledButton = styled.div`
        display: flex;
        width: 13.87rem;
        align-items: center;
        height: 3.125rem;
        flex-direction: column;
        justify-content:center;
        flex-shrink: 0;
        color: var(--Black-color-Text, #0A142F);
        background:#F5A42ECC; 
        border: none;
        border-radius: 0.31rem;
        margin-left:24rem;
        margin-top:18.75rem;
        margin-bottom:18.75rem;
 
        
        .CustomButton {
            width: 100%; /* Certifica-se de que o botão ocupe toda a largura do StyledButton */
            height: 100%; /* Certifica-se de que o botão ocupe toda a altura do StyledButton */
            display: flex;
            align-items: center;
            justify-content: center;
            color: var(--Black-color-Text, #0A142F);
            background: inherit; /* Herda a cor de fundo do StyledButton */
            border: none;
            border-radius: inherit; /* Herda a borda do StyledButton */
            font-family: Poppins;
            font-size: 2rem;
            font-style: normal;
            font-weight: 800;
            line-height: 0.93rem;
            letter-spacing: 0.15rem;
            cursor: pointer; /* Adicionei um cursor para indicar que é clicável */
        }

        .H6{
            text-align: center;
            font-family: Poppins;
            font-size:2rem;
            font-style: normal;
            font-weight: 800;
            line-height: 0.93rem; /* 50% */
            letter-spacing: 0.03rem;
        }       
`