export const mainCategory = [
  {
    name: "Crops",
    categoryId: "crops",
    level: 1,
    levelTwoCategory: [
      {
        name: "Grains",
        categoryId: "grains",
        parentCategoryId: "crops",
        level: 2,
      },
      {
        name: "Vegetables",
        categoryId: "vegetables",
        parentCategoryId: "crops",
        level: 2,
      },
      {
        name: "Fruits",
        categoryId: "fruits",
        parentCategoryId: "crops",
        level: 2,
      },
      {
        name: "Oilseeds",
        categoryId: "oilseeds",
        parentCategoryId: "crops",
        level: 2,
      },
      {
        name: "Spices",
        categoryId: "spices",
        parentCategoryId: "crops",
        level: 2,
      },
    ],
  },
  {
    name: "Livestock",
    categoryId: "livestock",
    level: 1,
    levelTwoCategory: [
      {
        name: "Cattle",
        categoryId: "cattle",
        parentCategoryId: "livestock",
        level: 2,
      },
      {
        name: "Poultry",
        categoryId: "poultry",
        parentCategoryId: "livestock",
        level: 2,
      },
      {
        name: "Sheep & Goats",
        categoryId: "sheep_goats",
        parentCategoryId: "livestock",
        level: 2,
      },
      {
        name: "Pigs",
        categoryId: "pigs",
        parentCategoryId: "livestock",
        level: 2,
      },
      {
        name: "Other Animals",
        categoryId: "other_animals",
        parentCategoryId: "livestock",
        level: 2,
      },
    ],
  },
  {
    name: "Farm Machinery",
    categoryId: "farm_machinery",
    level: 1,
  },
  {
    name: "Seeds & Fertilizers",
    categoryId: "seeds_fertilizers",
    level: 1,
  },
];
