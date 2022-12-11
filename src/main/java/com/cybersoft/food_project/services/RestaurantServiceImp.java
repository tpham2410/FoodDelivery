package com.cybersoft.food_project.services;

import com.cybersoft.food_project.dto.RestaurantDTO;
import com.cybersoft.food_project.dto.RestaurantDetailDTO;
import com.cybersoft.food_project.entity.FoodEntity;
import com.cybersoft.food_project.entity.RestaurantEntity;
import com.cybersoft.food_project.entity.RestaurantReviewEntity;
import com.cybersoft.food_project.model.FoodModel;
import com.cybersoft.food_project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> dtos = new ArrayList<>();

        List<RestaurantEntity> restaurantEntities = restaurantRepository.findAll();

        //Xử lý data:{ title: "", image: "", avgRate: ""}
        for (RestaurantEntity data : restaurantEntities){
            RestaurantDTO restaurantDTO = new RestaurantDTO();

            restaurantDTO.setTitle(data.getName());
            restaurantDTO.setImage(data.getImage());

            float avgRate = 0;
            float sumRate = 0;

            for(RestaurantReviewEntity dataReview : data.getRestaurantReviewEntities()){

                sumRate += dataReview.getRate();
            }

            if(data.getRestaurantReviewEntities().size()>0){
                avgRate = sumRate/data.getRestaurantReviewEntities().size();
            }

            restaurantDTO.setAvgRate(avgRate);

            dtos.add(restaurantDTO);

        }
        return dtos;
    }

    @Override
    public RestaurantDetailDTO getDetailedRestaurant(int id) {
        Optional<RestaurantEntity> restaurantEntity = Optional.ofNullable(restaurantRepository.findById(id));
        RestaurantDetailDTO restaurantDetailDTO = new RestaurantDetailDTO();

        if(restaurantEntity.isPresent()){

            List<FoodModel> foodModelList = new ArrayList<>();

            restaurantDetailDTO.setTitle(restaurantEntity.get().getName());
            restaurantDetailDTO.setImage(restaurantEntity.get().getImage());

                float avgRate = 0;
                float sumRate = 0;

                for(RestaurantReviewEntity dataDetailed : restaurantEntity.get().getRestaurantReviewEntities()){

                    sumRate += dataDetailed.getRate();
                }

                if(restaurantEntity.get().getRestaurantReviewEntities().size()>0){
                    avgRate = sumRate/restaurantEntity.get().getRestaurantReviewEntities().size();
                }

                for(FoodEntity foodData: restaurantEntity.get().getFoodEntities()){
                    FoodModel foodModel = new FoodModel();

                    foodModel.setId(foodData.getId());
                    foodModel.setName(foodData.getName());
                    foodModel.setImage(foodData.getImage());
                    foodModel.setPrice(foodData.getPrice());

                    foodModelList.add(foodModel);
                }
            restaurantDetailDTO.setFoodModels(foodModelList);
            restaurantDetailDTO.setAvgRate(avgRate);
        }

        return restaurantDetailDTO;
    }
}
