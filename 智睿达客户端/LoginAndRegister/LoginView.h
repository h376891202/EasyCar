//
//  LoginView.h
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LoginView : UIView


@property (strong, nonatomic) IBOutlet UIButton *findPasswordButton;

@property (strong, nonatomic) IBOutlet UIView *passwordView;


@property (strong, nonatomic) IBOutlet UIButton *loginButton;


@property (strong, nonatomic) IBOutlet UITextField *passwordTextField;


@property (strong, nonatomic) IBOutlet UITextField *phoneTextField;


@property (strong, nonatomic) IBOutlet UIView *phoneView;


@property (strong, nonatomic) IBOutlet UIButton *registerButton;


@property (strong, nonatomic) IBOutlet UIButton *backButton;

@property (strong, nonatomic) IBOutlet UILabel *titleLabel;


@end
