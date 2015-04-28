//
//  ZhiRuiDaHeader.h
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#ifndef _______ZhiRuiDaHeader_h
#define _______ZhiRuiDaHeader_h


//定义返回请求数据的block类型
typedef void (^ReturnValueBlock) (id returnValue , int statusCode);
typedef void (^ErrorCodeBlock) (id errorCode);
typedef void (^FailureBlock)();
//typedef void (^NetWorkBlock)(BOOL netConnetState);

#define IMAGE(_NAME) [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForAuxiliaryExecutable:_NAME]]
#define COLOR(_R,_G,_B,_A) [UIColor colorWithRed:_R / 255.0f green:_G / 255.0f blue:_B / 255.0f alpha:_A]
#define SCREEN_Width [UIScreen mainScreen].bounds.size.width
#define SCREEN_Height [UIScreen mainScreen].bounds.size.height

#define DDLog(xx, ...)  NSLog(@"%s(%d): " xx, __PRETTY_FUNCTION__, __LINE__, ##__VA_ARGS__)

#define NOW_SIZE [UIScreen mainScreen].bounds.size.width/320

#import <BaiduMapAPI/BMapKit.h>
#import "AFNetworking.h"
#import "MJRefresh.h"
#import "UIImageView+WebCache.h"
#import "MBProgressHUD.h"
#import "MBProgressHUDManager.h"
#import "SVProgressHUD.h"
#import "BaseRequest.h"
#import "UserInfo.h"
#import "UIView+ViewClass.h"
#import "UIButton+buttonClass.h"


#endif
