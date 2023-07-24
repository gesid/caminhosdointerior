import Face from '../../assets/face.svg'
import Insta from '../../assets/insta.svg'
import Twitter from '../../assets/twitter.svg'
import { StyledSocialMedia } from './styled';

const RedesSociais = () => {
    return (
        <StyledSocialMedia>
            <h6>REDES SOCIAIS</h6>
            <div className="logo">
                <img src={Face} alt="Logo face" />
                <img src={Insta} alt="Logo insta" />
                <img src={Twitter} alt="Logo twitter" />
            </div>
        </StyledSocialMedia>
    );
};

export default RedesSociais;