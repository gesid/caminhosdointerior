import styled from 'styled-components';

export const StyledOverLay = styled.div`
    width: 100%;
    height: 3.6rem;
    z-index: 3;
    border-bottom: 2px solid ${(props) => props.theme.colors.lightGray};
    position: absolute;
`

export const StyledFooter = styled.div`
    background-color: #E4E4D3;
    width: auto;
    height: 15rem;
    padding:1.9rem 5rem 0.9rem;
    font-size: 1rem;
    color: black;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    
    h5{
        margin-top:auto;
        text-decoration: solid;
        font-size: 1rem;
    }
;

`
export const StyledList = styled.div`
    gap:1.25rem;
    flex-direction: column;
    font-size: 1.25rem;
    color: black;
    display: flex;

    h6{
        font-size: 1.25rem;
    }

    li{ 
        list-style: none;
        font-size: 1rem;
    }
;
`

export const StyledSocialMedia = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    
    h6{
        font-size: 1.25rem;
    }

    gap: 1.25rem;
    .logo{
        display:flex;
        gap:0.6rem;
     }
`


export const StyledNotFoundPageText1 = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 18.75rem;
    
    .text1{
        width: 35.90rem;
        height: 9.37rem;
    }
`

export const StyledNotFoundPageText2 = styled.div`
    justify-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-bottom: 20.62rem;
    margin-left:3rem;
    
    .text2{
        width: 41.31rem;
        height: 18.75rem;
    }
`
export const StyledNotFoundImage = styled.img`
    width: 84rem;
    height: 35rem;  
`