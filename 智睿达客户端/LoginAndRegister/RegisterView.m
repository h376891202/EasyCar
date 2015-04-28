//
//  RegisterView.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "RegisterView.h"

@implementation RegisterView


- (void)awakeFromNib
{
    [_phoneView setLayerType];
    [_vertifyView setLayerType];
    [_passwordView setLayerType];
    [_confirmPasswordView setLayerType];
    _vertifyButton.layer.cornerRadius = 14*NOW_SIZE;
    [_backButton setImage:IMAGE(@"narrow.png") forState:UIControlStateNormal];
    [_backButton setButtonImageStyle];
}

@end
