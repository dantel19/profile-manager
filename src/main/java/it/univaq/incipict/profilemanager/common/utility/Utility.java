/*
 * Profile Manager - Copyright (C) 2016  Daniele Tellina
 *
 * Profile Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * Profile Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with Profile Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.univaq.incipict.profilemanager.common.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;

import it.univaq.incipict.profilemanager.business.model.Information;
import it.univaq.incipict.profilemanager.business.model.Profile;
import it.univaq.incipict.profilemanager.business.model.ProfileInformation;
import it.univaq.incipict.profilemanager.business.model.User;

/**
 * 
 * @author Daniele Tellina
 *
 */
public class Utility {

   public static Date actualDate() {
        return new Date();
    }
   
   // this method calculate the Euclidean Distances between
   // the answers vector of a single survey and the ranks vector of each
   // different profile.
   public static HashMap<Profile, Double> getEuclideanDistances(List<Profile> profilesList, User user) {
      Map<Profile, Double> result = new HashMap<Profile, Double>();
      Set<ProfileInformation> profileInformationSet;
      Set<Information> userInformationSet;
      
      // Retrieve user information set
      userInformationSet = user.getInformationSet();
      if (userInformationSet.isEmpty()) {
         return (HashMap<Profile, Double>) result;
      }
      
      // For each Profile
      for (Profile profile : profilesList) {
         profileInformationSet = profile.getProfileInformationSet();
         int vectorsLenght = Math.max(profileInformationSet.size(), userInformationSet.size());
         RealVector ranksRealVector = new ArrayRealVector(new double[]{});
         RealVector userInformationVector = new ArrayRealVector(new double[]{});
         
         
         // Loop userInformationSet and 
         // profileInformationSet (i.e. one specific column vector in the knowledge base representation)
         for (Information information : userInformationSet) {
            Long x = information.getId();
            for (ProfileInformation profileInformation : profileInformationSet) {
               Long y = profileInformation.getInformation().getId();
               // User selected information was stored in a RealVector at same position of relative ranksVector
               // This permit to calculate Euclidean distance right.
               if (x == y) {
                  
                  userInformationVector = userInformationVector.append(1d); // Associated: 1 , Else: 0
                  ranksRealVector = ranksRealVector.append(profileInformation.getRank());
                 
                  profileInformationSet.remove(profileInformation);
                  break;
               }
            }
         }
         // At this point we aren't interested to elements position
         // because every other information worth zero.
         // Euclidean distance are not influenced from position of 0-elements in a "sub-vector".
         // if they are all zeros.
         // => Append the zeros until completion of the length of the vectors
         userInformationVector = userInformationVector.append(new double[vectorsLenght-userInformationSet.size()]);

         for (ProfileInformation profileInformation : profileInformationSet) {
            // Append the remaining elements of this set (profileInformationSet)
            ranksRealVector = ranksRealVector.append(profileInformation.getRank());
         }
         
         // Calculate Euclidean Distance
         double distance = userInformationVector.getDistance(ranksRealVector);
         // add the distance to Distance's Map
         result.put(profile, distance);
         
      } // END, goto Next Profile
      
      //return the HashMap sorted by value (ASC)
      return (HashMap<Profile, Double>) MapUtil.sortByValueASC(result);
   }
   
   public static HashMap<Profile, Float> getPercentages(HashMap<Profile, Double> distances, int informationSetSize) {
      Map<Profile, Float> result = new HashMap<Profile, Float>();
      
      if (distances.isEmpty() || distances == null) { return new HashMap<Profile, Float>(); }
      else {
         for (Map.Entry<Profile, Double> entry : distances.entrySet()) {
            Profile profile = entry.getKey();
            Double distance = entry.getValue();
            
            // Calculate the percentage for the current distance
            // The maximum distance is sqrt(informationSetSize) because we have 0-1 vectors
            // REMARK: Euclidean Distance Theory
            float maxDistance = (float) Math.sqrt(informationSetSize);
            float percentage = (float) (maxDistance - distance) * 100 / maxDistance;
            
            // put the percentage in Map formatted with two decimals.
            result.put(profile, (float) (Math.round(percentage * 100.0) / 100.0));
         }
      }
      //return the HashMap sorted by value (DESC)
      return (HashMap<Profile, Float>) MapUtil.sortByValueDESC(result);
   }

   public static Profile getBestProfile(HashMap<Profile, Double> distancesMap) {
      if (distancesMap.isEmpty() || distancesMap == null) return null;
      //return the first element because the distances map is sorted by values
      // REF: getEuclideanDistances() method
      return distancesMap.keySet().iterator().next();
   }

}
