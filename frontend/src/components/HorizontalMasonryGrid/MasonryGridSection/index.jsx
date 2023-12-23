
import { OneImageGridSection } from "./OneImageGridSection";
import { TwoImagesGridSection } from "./TwoImagesGridSection";
import { ThreeImagesGridSection } from "./ThreeImagesGridSection";

export const MasonryGridSection = ({ data: section }) => {
  if(section.type === "TWO_IMAGES"){
    return (<TwoImagesGridSection data={section} />);
  }

  if(section.type === "THREE_IMAGES"){
    return (<ThreeImagesGridSection data={section} />);
  }

  return (<OneImageGridSection data={section} />);
};
