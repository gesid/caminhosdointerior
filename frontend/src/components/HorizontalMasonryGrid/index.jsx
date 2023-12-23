import { useMemo } from "react";

import { generateRandomNumberInTrack } from "../../utils/generateRandomNumberInTrack";
import { MasonryGridSection } from "./MasonryGridSection";

import * as S from "./styles";

export const HorizontalMasonryGrid = ({ data }) => {
  const gridSections = useMemo(() => {
    return createGridSections(data);
  }, []);

  function createGridSections(gridItems) {
    const gridSections = [];

    let sectionId = 0;
    let index = 0;

    while (index < gridItems.length) {
      sectionId++;
      
      let gridSectionItemsTotal = getNewGridSectionItemsTotal(gridSections.length);

      const gridSectionItems = gridItems.slice(index, index + gridSectionItemsTotal);
      const gridSection = getNewGridSection(gridSectionItems, sectionId);

      gridSections.push(gridSection);
      
      index += gridSectionItemsTotal;
    }

    return gridSections;
  }

  function getNewGridSectionItemsTotal(currentGridSectionsTotal){
    let subarraySize = 1;

    if (currentGridSectionsTotal % 3 === 1) {
      subarraySize = 2;
    } else if (currentGridSectionsTotal % 3 === 2) {
      subarraySize = 3;
    }

    return subarraySize;
  }

  function getNewGridSection(gridSectionItems, sectionId){
    if (gridSectionItems.length === 1) {
      const oneImageSection = generateOneImageGridSection(gridSectionItems);
      return { ...oneImageSection, id: sectionId };
    }

    if (gridSectionItems.length === 2) {
      const twoImagesSection = generateTwoImagesGridSection(gridSectionItems);
      return { ...twoImagesSection, id: sectionId };
    }
   
    if (gridSectionItems.length === 3) {
      const threeImagesSection = generateThreeImagesGridSection(gridSectionItems);
      return { ...threeImagesSection, id: sectionId };
    } 

    throw new Error('Invalid grid items total');
  }

  function generateOneImageGridSection(items) {
    const sectionWidthInRemUnit = generateRandomSectionWidth();

    return {
      type: "ONE_IMAGE",
      data: items,
      width: sectionWidthInRemUnit,
    };
  }

  function generateTwoImagesGridSection(items) {
    const sectionWidthInRemUnit = generateRandomSectionWidth();

    const topImageHeightInPercentage = generateRandomNumberInTrack(26, 65);
    const bottomImageHeightInPercentage = 100 - topImageHeightInPercentage - 2;

    return {
      type: "TWO_IMAGES",
      data: items,
      width: sectionWidthInRemUnit,
      sizingOptions: {
        topImageHeight: `${topImageHeightInPercentage}%`,
        bottomImageHeight: `${bottomImageHeightInPercentage}%`,
      },
    };
  }

  function generateThreeImagesGridSection(items) {
    const sectionWidthInRemUnit = generateRandomSectionWidth();

    const topImageHeightInPercentage = generateRandomNumberInTrack(26, 65);
    const bottomImagesHeightInPercentage = 100 - topImageHeightInPercentage - 2;

    const bottomLeftImageWitdhInPercentage = generateRandomNumberInTrack(
      20,
      68
    );
    const bottomRigthImageWitdhInPercentage =
      100 - bottomLeftImageWitdhInPercentage - 2;

    return {
      type: "THREE_IMAGES",
      data: items,
      width: sectionWidthInRemUnit,
      sizingOptions: {
        topImageHeight: `${topImageHeightInPercentage}%`,
        bottomImagesHeight: `${bottomImagesHeightInPercentage}%`,
        bottomLeftImageWitdh: `${bottomLeftImageWitdhInPercentage}%`,
        bottomRightImageWitdh: `${bottomRigthImageWitdhInPercentage}%`,
      },
    };
  }

  function generateRandomSectionWidth(){
    return generateRandomNumberInTrack(16, 36) + "rem";
  }

  return (
    <S.Container>
      {gridSections.map((section) => (
        <MasonryGridSection key={section.id} data={section} />
      ))}
    </S.Container>
  );
};
