import { styled } from "styled-components";

export const Search = styled.div`
    display: flex;
    align-items: center;
    border-radius: 5rem;
    box-shadow: 0px 4px 4px #00000040;
`
export const LabelSearch = styled.label`
    background: #fff;
    padding: 10px;
    border-radius: 5rem 0 0 5rem;

`
export const IconSearch = styled.img`
    height: 23px;
`
export const InputSearch = styled.input`
    width: 700px;
    height: 47px;
    border: none;
    outline: none;
    padding-left: 5px;
    border-radius: 0 5rem 5rem 0;
    &::placeholder {
        font-style: italic;
        font-weight: 400;
        font-size: 17px;
        color: #9B9B9B;
    }
`