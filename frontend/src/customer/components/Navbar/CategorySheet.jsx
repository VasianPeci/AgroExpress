import React from "react";
import { cropsLevelTwo } from "../../../data/category/level two/cropsLevelTwo";
import { livestockLevelTwo } from "../../../data/category/level two/livestockLevelTwo";
import { livestockLevelThree } from "../../../data/category/level three/livestockLevelThree";
import { farmMachineryLevelTwo } from "../../../data/category/level two/farmMachineryLevelTwo";
import { seedsFertilizersLevelTwo } from "../../../data/category/level two/seedsFertilizersLevelTwo";
import { cropsLevelThree } from "../../../data/category/level three/cropsLevelThree";
import { farmMachineryLevelThree } from "../../../data/category/level three/farmMachineryLevelThree";
import { seedsFertilizersLevelThree } from "../../../data/category/level three/seedsFertilizersLevelThree";
import { useNavigate } from "react-router-dom";
import { Box } from "@mui/material";

const categoryTwo = {
  crops: cropsLevelTwo,
  livestock: livestockLevelTwo,
  farm_machinery: farmMachineryLevelTwo,
  seeds_fertilizers: seedsFertilizersLevelTwo,
};

const categoryThree = {
  crops: cropsLevelThree,
  livestock: livestockLevelThree,
  farm_machinery: farmMachineryLevelThree,
  seeds_fertilizers: seedsFertilizersLevelThree,
};

const CategorySheet = ({ selectedCategory, toggleDrawer, setShowSheet }) => {
  const navigate = useNavigate();

  const childCategory = (category, parentCategoryId) => {
    return category.filter(
      (child) => child.parentCategoryId === parentCategoryId
    );
  };

  const handleCategoryClick = (category) => {
    if (toggleDrawer) {
      toggleDrawer(false)();
    }
    if (setShowSheet) {
      setShowSheet(false);
    }
    navigate("/products/" + category);
  };

  return (
    <Box className="bg-white shadow-lg lg:h-[500px] overflow-y-auto">
      <div className="flex text-sm flex-wrap">
        {categoryTwo[selectedCategory]?.map((item, index) => (
          <div
            key={item.name}
            className={`p-8 lg:w-[20%] ${
              index % 2 === 0 ? "bg-slate-50" : "bg-white"
            }`}
          >
            <p className="text-[#3f51b5] mb-5 font-semibold">{item.name}</p>
            <ul className="space-y-3">
              {childCategory(
                categoryThree[selectedCategory],
                item.categoryId
              )?.map((subItem) => (
                <li
                  key={subItem.name}
                  onClick={() => handleCategoryClick(subItem.categoryId)}
                  className="hover:text-[#3f51b5] cursor-pointer"
                >
                  {subItem.name}
                </li>
              ))}
            </ul>
          </div>
        ))}
      </div>
    </Box>
  );
};

export default CategorySheet;
